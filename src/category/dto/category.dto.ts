import { CategoryBase } from "./categorybase.dto";
import { SubcategoryLevel2 } from "./subcategoryLevel2.dto";

export class Category extends CategoryBase {
    subcategories?: SubcategoryLevel2[]
}
