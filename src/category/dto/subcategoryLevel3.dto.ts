import { CategoryBase } from "./categorybase.dto"
import { SubcategoryLevel4 } from "./subcategoryLevel4.dto"

export class SubcategoryLevel3 extends CategoryBase {
    iconImageUrl: string
    mediumImageUrl:	string
    smallImageUrl:	string
    subcategories?: SubcategoryLevel4[]
}