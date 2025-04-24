import { Inject, Injectable } from '@nestjs/common';
import { HttpClientRequestDto } from 'src/shared/domain/dto/http-client-request.dto';
import { HttpClientService } from './http-client.interface';
import Axios, { AxiosResponse, AxiosRequestConfig, AxiosError } from 'axios';
import { Agent } from 'https';
import { TYPES } from 'src/shared/utils/types';
import { LoggerService } from '../logger/logger.service';

@Injectable()
export class AxiosService implements HttpClientService {
  private readonly environmentsSslVerificationDisabled = ['local'];

  constructor(
    @Inject(TYPES.LoggerService)
    private readonly loggerService: LoggerService,
  ) {}

  async get<T>(httpClientRequestDto: HttpClientRequestDto): Promise<T> {
    const { url, headers, params } = httpClientRequestDto;
    const config: AxiosRequestConfig = { headers, params };
    this.configureSslVerification(config);
    const func = async () => Axios.get(url, config);
    return this.execute(func, httpClientRequestDto);
  }

  async post<T>(httpClientRequestDto: HttpClientRequestDto): Promise<T> {
    const { url, body, headers, params } = httpClientRequestDto;
    const config: AxiosRequestConfig = { headers, params };
    this.configureSslVerification(config);
    const func = async () => Axios.post(url, body, config);
    return this.execute(func, httpClientRequestDto);
  }

  private configureSslVerification(config: AxiosRequestConfig) {
    if (
      this.environmentsSslVerificationDisabled.includes(process.env.NODE_ENV)
    ) {
      config.httpsAgent = new Agent({
        rejectUnauthorized: false,
      });
    }
  }

  private async execute(
    func: () => Promise<AxiosResponse>,
    requestData: HttpClientRequestDto,
  ): Promise<any> {
   try {
       this.loggerService.info(
        `Consumo del API: ${requestData.url}`,
        requestData.body,
      );
      const { data } = await func();
      this.loggerService.info(`Respuesta del API: ${requestData.url}`, data);
      return data;
    } catch (error) {
      const axiosError: AxiosError = error;
      const errorResponse = {
        url: axiosError.config.url,
        statusCode: axiosError.status || axiosError.response?.status,
        message: axiosError.message,
        data: axiosError.response?.data,
      };
     this.loggerService.error(
        `Respuesta del API: ${requestData.url}`,
        errorResponse,
    );
      throw errorResponse;
    }
  }
}
