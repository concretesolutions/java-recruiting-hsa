import { Controller, Get, Query } from '@nestjs/common';
import { CategoryService } from '../services/category.service';
import { CategoryEntity } from '../entities/category.entity';
import { ApiQuery, ApiTags } from '@nestjs/swagger';

@ApiTags('category')
@Controller('category')
export class GetFindTopController {
  constructor(
    private readonly categoryService: CategoryService) {}

  @Get('top')
  @ApiQuery({ name: 'limit', required: true, type: Number })
  public async findTop(@Query('limit') num: Readonly<number>): Promise<Readonly<CategoryEntity[]>>  {
    return await this.categoryService.findTop(num);
  }
}
