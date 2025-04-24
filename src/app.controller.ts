import { Controller, Get, Query } from '@nestjs/common';
import { AppService } from './app.service';

@Controller('dashboard')
export class AppController {
  constructor(private readonly appService: AppService) { }

  @Get('/')
  public async dashboard(@Query('limit') num: number) {
    return await this.appService.getDashboard(num);
  }
}
