import { Inject, Injectable } from '@nestjs/common';
import { HttpClientService } from 'src/shared/infrastructure/http-client/http-client.interface';
import { TYPES } from 'src/shared/utils/types';
import { Category } from '../dto/category.dto';
import { CategoryRepository } from './category.repository';
import { ConfigService } from '@nestjs/config';

@Injectable()
export class CategoryAxiosRepository implements CategoryRepository {
    constructor(
        @Inject(TYPES.HttpClientService)
        private readonly httpClientService: HttpClientService,
        private readonly configService: ConfigService
    ) {}

    async findAll(): Promise<Readonly<Category>> {
        return await this.httpClientService.get<Readonly<Category>>({
            url: this.configService.get<Readonly<string>>('API_CATEGORY'),
        });
    }
}