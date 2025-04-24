import { ApiProperty } from "@nestjs/swagger"

export class CategoryEntity {  
    @ApiProperty() readonly id: string
    @ApiProperty() readonly name: string
    @ApiProperty() readonly relevance?: number
    @ApiProperty() readonly smallImageUrl?: string
    @ApiProperty() readonly subcategories?: CategoryEntity[]
}
