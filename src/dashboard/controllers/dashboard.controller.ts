import { Controller, Get, Query } from '@nestjs/common';
import { DashboardService } from '../services/dashboard.service';
import { Dashboard } from '../entities/dashboard.entity';
import { ApiTags, ApiQuery } from '@nestjs/swagger';

@ApiTags('dashboard')
@Controller('dashboard')
export class DashboardController {
  constructor(private readonly dashboardService: DashboardService) { }

  @Get()
  @ApiQuery({ name: 'limit', required: true, type: Number })
  public async dashboard(@Query('limit') num: Readonly<number>): Promise<Readonly<Dashboard>> {
    return await this.dashboardService.getDashboard(num);
  }
}
