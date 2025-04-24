import { Inject, Injectable, InternalServerErrorException } from '@nestjs/common';
import { CreateCategoryDto } from '../dto/create-category.dto';
import { UpdateCategoryDto } from '../dto/update-category.dto';
import { CategoryRepository } from '../repositories/category.repository';
import { CATEGORY_REPOSITORY } from 'src/shared/utils/tokens';
import { CategoryEntity } from '../entities/category.entity';
import { LoggerService } from 'src/shared/infrastructure/logger/logger.service';
import { TYPES } from 'src/shared/utils/types';
import { SubcategoryLevel2 } from '../dto/subcategoryLevel2.dto';
import { Category } from '../dto/category.dto';

@Injectable()
export class CategoryService {
  constructor(
    @Inject(CATEGORY_REPOSITORY) private readonly categoryRepository: CategoryRepository,
    @Inject(TYPES.LoggerService) private readonly logger: LoggerService
  ) { }

  private async getSubcategoriesL2() : Promise<Readonly<SubcategoryLevel2[]>> {
    const category : Readonly<Category> = await this.categoryRepository.findAll();
    return category?.subcategories;
  }

  async findTop(num: Readonly<number>): Promise<CategoryEntity[]>
  {
    try {
      const subcategoriesL2 : Readonly<SubcategoryLevel2[]> = await this.getSubcategoriesL2();
      return this.sortCategoriesTop(subcategoriesL2, num);
    } catch (error) {
      this.logger.error('error requesting top categories');
      throw new InternalServerErrorException('error requesting top categories');
    }
  }

  async findNoTop(num: Readonly<number>): Promise<Readonly<CategoryEntity[]>> {
    try {
      const subcategoriesL2 : Readonly<SubcategoryLevel2[]> = await this.getSubcategoriesL2();
      return this.sortCategoriesNoTop(subcategoriesL2, num);
    } catch (error) {
      this.logger.error('error requesting non-top categories');
      throw new InternalServerErrorException('error requesting non-top categories');    
    }
  }

  private sortCategoriesTop(subcategoriesArray: Readonly<any>, num: Readonly<number>): CategoryEntity[] {

    this.sortByRelevance(subcategoriesArray);

    subcategoriesArray = subcategoriesArray.slice(0, num);

    return subcategoriesArray.map(({
      id,
      name,
      relevance,
      smallImageUrl,
      subcategories }) => ({
        id,
        name,
        relevance,
        smallImageUrl,
        subcategories: subcategories ? this.sortCategoriesTop(subcategories, num) : undefined,
      }));
  }

  private sortCategoriesNoTop(subcategoriesArray: Readonly<any>, num: Readonly<number>): Readonly<CategoryEntity[]> {

    this.sortByRelevance(subcategoriesArray);

    subcategoriesArray = this.sliceFromNumber(subcategoriesArray, num);

    if (subcategoriesArray) {
      return subcategoriesArray.map(({
        id,
        name,
        relevance,
        smallImageUrl,
        subcategories }) => ({
          id,
          name,
          relevance,
          smallImageUrl,
          subcategories: subcategories ? this.sortCategoriesNoTop(subcategories, num) : undefined,
        }));
    }
    return undefined;
  }

  private sliceFromNumber(categoriesNonTop: any, num: Readonly<number>): Readonly<CategoryEntity[]> {
    categoriesNonTop = categoriesNonTop.length >= num ? categoriesNonTop.slice(num) : categoriesNonTop;
    return categoriesNonTop;
  }

  private sortByRelevance(subcategories: any) {
    if (subcategories.length > 1) {
      subcategories.sort((a, b) => {
        const relevanceA = a.relevance ?? 0;
        const relevanceB = b.relevance ?? 0;
        return relevanceB - relevanceA;
      });
    }
  }

  

  create(createCategoryDto: CreateCategoryDto) {
    return 'This action adds a new category';
  }

  findAll() {
    return `This action returns all category`;
  }

  findOne(id: number) {
    return `This action returns a #${id} category`;
  }

  update(id: number, updateCategoryDto: UpdateCategoryDto) {
    return `This action updates a #${id} category`;
  }

  remove(id: number) {
    return `This action removes a #${id} category`;
  }
}
