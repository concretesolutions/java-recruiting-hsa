import { Category } from "../dto/category.dto";

export interface CategoryRepository {
    findAll(): Promise<Readonly<Category>>;
}