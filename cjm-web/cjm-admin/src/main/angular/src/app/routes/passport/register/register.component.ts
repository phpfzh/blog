import {Component, Inject, OnDestroy, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {
  FormGroup,
  FormBuilder,
  Validators,
  FormControl,
} from '@angular/forms';
import {NzMessageService} from 'ng-zorro-antd';
import {UserRegisterService} from "../../../generated/service/user-register.service";
import {DA_SERVICE_TOKEN, TokenService} from "@delon/auth";

@Component({
  selector: 'passport-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.less'],
})
export class UserRegisterComponent implements OnDestroy, OnInit {

  form: FormGroup;
  error = '';
  type = 0;
  loading = false;
  visible = false;
  status = 'pool';
  progress = 0;
  passwordProgressMap = {
    ok: 'success',
    pass: 'normal',
    pool: 'exception',
  };

  constructor(fb: FormBuilder,
              private router: Router,
              public msg: NzMessageService,
              @Inject(DA_SERVICE_TOKEN) private tokenService: TokenService,
              private userRegisterService: UserRegisterService) {
    this.form = fb.group({
      username: [null, [Validators.required]],
      mail: [null, [Validators.email]],
      password: [
        null,
        [
          Validators.required,
          Validators.minLength(6),
          UserRegisterComponent.checkPassword.bind(this),
        ],
      ],
      confirm: [
        null,
        [
          Validators.required,
          Validators.minLength(6),
          UserRegisterComponent.passwordEquar,
        ],
      ],
      mobilePrefix: ['+86'],
      mobile: [null, [Validators.required, Validators.pattern(/^1\d{10}$/)]],
      captcha: [null, [Validators.required]],
    });
  }

  ngOnInit(): void {
    this.userRegisterService.generateUserName().subscribe(
      rep => {
        if (rep.code == "88") {
          this.form.patchValue({
            username: rep.data.username
          });
        }
      }
    );
  }

  static checkPassword(control: FormControl) {
    if (!control) return null;
    const self: any = this;
    self.visible = !!control.value;
    if (control.value && control.value.length > 9) self.status = 'ok';
    else if (control.value && control.value.length > 5) self.status = 'pass';
    else self.status = 'pool';

    if (self.visible)
      self.progress =
        control.value.length * 10 > 100 ? 100 : control.value.length * 10;
  }

  static passwordEquar(control: FormControl) {
    if (!control || !control.parent) return null;
    if (control.value !== control.parent.get('password').value) {
      return {equar: true};
    }
    return null;
  }

  // region: fields

  get username() {
    return this.form.controls.username;
  }

  get mail() {
    return this.form.controls.mail;
  }

  get password() {
    return this.form.controls.password;
  }

  get confirm() {
    return this.form.controls.confirm;
  }

  get mobile() {
    return this.form.controls.mobile;
  }

  get captcha() {
    return this.form.controls.captcha;
  }

  // endregion

  // region: get captcha

  count = 0;
  interval$: any;

  getCaptcha() {
    const mobile = this.mobile.value;
    if (!mobile) {
      this.msg.error("手机号不能为空");
      return;
    }

    this.userRegisterService.ssmRegCode(mobile).subscribe(
      rep => {
        if (rep.code == "88") {
          this.msg.success("短信发送成功");
          this.count = 59;
          this.interval$ = setInterval(() => {
            this.count -= 1;
            if (this.count <= 0) clearInterval(this.interval$);
          }, 1000);
        } else {
          this.msg.error(rep.message);
        }
      }
    )
  }

  // endregion

  submit() {
    this.error = '';
    for (const i in this.form.controls) {
      this.form.controls[i].markAsDirty();
      this.form.controls[i].updateValueAndValidity();
    }
    if (this.form.invalid) return;

    const mobile = this.mobile.value;
    const captcha = this.captcha.value;
    const username = this.username.value;
    const password = this.password.value;
    let mail = this.mail.value;
    if (!mail) {
      mail = "";
    }
    this.loading = true;
    this.userRegisterService.register(
      mobile,
      password,
      captcha,
      username,
      mail
    ).subscribe(
      rep => {
        this.loading = false;
        if (rep.code == "00") {
          this.msg.error(rep.message);
          return;
        }

        // 设置Token信息
        this.tokenService.set({
          token: rep.data.token,
          username: rep.data.username
        });
         this.router.navigate(['/passport/register-result']);
      }
    );

  }

  ngOnDestroy(): void {
    if (this.interval$) clearInterval(this.interval$);
  }
}
