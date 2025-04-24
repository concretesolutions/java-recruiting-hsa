import { Controller, Get, Query } from '@nestjs/common';
import { CategoryService } from '../services/category.service';
import { CategoryEntity } from '../entities/category.entity';
import { ApiQuery, ApiTags } from '@nestjs/swagger';

@ApiTags('category')
@Controller('category')
export class GetFindNoTopController {
  constructor(
    private readonly categoryService: CategoryService) {}

  @Get('notop')
  @ApiQuery({ name: 'from', required: true, type: Number })
  public async findNoTop(@Query('from') num: Readonly<number>): Promise<Readonly<CategoryEntity[]>>  {
    return await this.categoryService.findNoTop(num);
  }
}
