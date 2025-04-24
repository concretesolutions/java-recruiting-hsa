import { Global, Module } from '@nestjs/common';
import { TYPES } from './utils/types';
import { WinstonLoggerService } from './infrastructure/logger/winston-logger.service';
import { AxiosService } from './infrastructure/http-client/axios.service';
import { ConfigModule } from '@nestjs/config';

@Global()
@Module({
  imports: [
    ConfigModule.forRoot({
      isGlobal: true,
      envFilePath: ['default.env'],
      cache: true,
    }),
  ],
  providers: [
    {
      provide: TYPES.LoggerService,
      useClass: WinstonLoggerService,
    },
    {
      provide: TYPES.HttpClientService,
      useClass: AxiosService,
    },
  ],
  exports: [
    TYPES.LoggerService,
    TYPES.HttpClientService,
  ],
})
export class SharedModule {} 