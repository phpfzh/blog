import { Component, OnInit } from '@angular/core';
import { _HttpClient } from '@delon/theme';
import {StartupService} from "@core/startup/startup.service";

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
})
export class DashboardComponent implements OnInit {

  constructor(
    private http: _HttpClient,
    private startupService:StartupService
  ) {
    this.startupService.load();
  }

  ngOnInit() {

  }

}
