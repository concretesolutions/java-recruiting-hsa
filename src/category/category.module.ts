import { Module } from '@nestjs/common';
import { CategoryService } from './services/category.service';
import { CategoryController } from './controllers/category.controller';
import { HttpModule } from '@nestjs/axios';
import { CATEGORY_REPOSITORY } from 'src/shared/utils/tokens';
import { CategoryAxiosRepository } from './repositories/category.repository-axios';
import { SharedModule } from 'src/shared/shared.module';
import { GetFindTopController } from './controllers/get-find-top.controller';
import { GetFindNoTopController } from './controllers/get-find-no-top.controller';

@Module({
  imports: [SharedModule, HttpModule],
  controllers: [ GetFindTopController, GetFindNoTopController, CategoryController,],
  providers: [
    CategoryService,
    {
      provide: CATEGORY_REPOSITORY,
      useClass: CategoryAxiosRepository,
    },
  ],
  exports: [CategoryService],
})
export class CategoryModule {}
