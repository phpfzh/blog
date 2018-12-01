import { Component, Input } from '@angular/core';
import { Menu, SettingsService, MenuService } from '@delon/theme';
import { Router, NavigationEnd } from '@angular/router';
import { filter } from 'rxjs/operators';

@Component({
  selector: 'layout-simple-sidebar',
  templateUrl: './sidebar.component.html',
  preserveWhitespaces: false,
})
export class LayoutSimpleSidebarComponent {
  @Input() isMobile: boolean;
  @Input() theme: string;

  menus: Menu[];

  constructor(
    private menuSrv: MenuService,
    private router: Router,
    public settings: SettingsService,
  ) {
    menuSrv.change.subscribe(res => this.genMenus(res));
    router.events
      .pipe(filter(e => e instanceof NavigationEnd))
      .subscribe(res => this.openStatus());
  }

  private genMenus(data?: Menu[]) {
    const res: Menu[] = [];
    let curMenu: Menu = null;
    const url = this.router.url;
    const inFn = (list: Menu[], parent: Menu) => {
      for (const item of list) {
        if (item._hidden === true) continue;
        if (!curMenu && item.link === url) {
          curMenu = item;
        }
        if (parent === null) res.push(item);
        if (item.children && item.children.length > 0) {
          inFn(item.children, item);
        } else {
          item.children = [];
        }
      }
    };
    // ingores category menus
    const ingoreCategores = (data || this.menuSrv.menus).reduce(
      (prev, cur) => prev.concat(cur.children),
      [],
    );
    inFn(ingoreCategores, null);
    if (curMenu) {
      curMenu._selected = true;
      do {
        curMenu = curMenu.__parent;
        if (curMenu) curMenu._open = true;
      } while (curMenu);
    }
    this.menus = res;
  }

  private openStatus() {
    let item: Menu;
    const url = this.router.url;
    const inFn = (list: Menu[], parent: Menu) => {
      for (const i of list) {
        i._open = false;
        i._selected = false;
        if (!item && i.link === url) {
          item = i;
          i._selected = true;
        }
        if (i.children && i.children.length > 0) {
          inFn(i.children, i);
        }
      }
    };
    inFn(this.menus, null);
    do {
      item = item.__parent;
      if (item) item._open = true;
    } while (item);
  }

  click(item: Menu) {
    if (item.externalLink) {
      if (item.target === '_blank') {
        window.open(item.externalLink);
      } else {
        location.href = item.externalLink;
      }
      return;
    }
    this.router.navigateByUrl(item.link);
    if (this.isMobile) {
      setTimeout(() => this.settings.setLayout('collapsed', true));
    }
  }
}
