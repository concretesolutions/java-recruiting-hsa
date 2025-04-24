import { HttpClientRequestDto } from 'src/shared/domain/dto/http-client-request.dto';
export interface HttpClientService {
  get<T>(httpClientRequestDto: HttpClientRequestDto): Promise<T>;
  post<T>(httpClientRequestDto: HttpClientRequestDto): Promise<T>;
}
