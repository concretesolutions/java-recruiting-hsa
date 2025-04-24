import { CategoryBase } from "./categorybase.dto"
import { SubcategoryLevel3 } from "./subcategoryLevel3.dto"

export class SubcategoryLevel2 extends CategoryBase {
    iconImageUrl: string
    subcategories?: SubcategoryLevel3[]
}