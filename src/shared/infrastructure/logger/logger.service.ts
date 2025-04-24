export interface LoggerService {
  debug(message: string, detail?: any): void;
  info(message: string, detail?: any): void;
  error(message: string, detail?: any): void;
}
