import { Injectable, LoggerService } from '@nestjs/common';
import * as winston from 'winston';
import 'winston-daily-rotate-file';

type Level = 'error' | 'info' | 'debug';

@Injectable()
export class WinstonLoggerService implements LoggerService {
  private readonly logger : winston.Logger;

  constructor() {   
    this.logger = winston.createLogger({        
      format: winston.format.combine(
        winston.format.timestamp({
          format: 'YYYY-MM-DD HH:mm:ss'
        }),
        winston.format.printf(info => `${info.timestamp} [${info.level.toUpperCase()}]: ${info.message}`)
      ), 
      transports: [       
        new winston.transports.Console({
          format: winston.format.simple(),
          level: 'silly',
        }),  // Log to the console
        new winston.transports.DailyRotateFile({
          level: 'silly',
          filename: 'logs/application-%DATE%.log',
          datePattern: 'YYYY-MM-DD',
          zippedArchive: true,
          maxSize: '20m',
          maxFiles: '1d'
        })
      ],
    });
  }

  debug(message: string, detail?: any) {
    const messageBody = this.log('debug', message, detail);
    this.logger.debug(messageBody);
  }

  info(message: string, detail?: any) {
    const messageBody = this.log('info', message, detail);
    this.logger.info(messageBody);
  }

  error(message: string, detail?: any) {
    const messageBody = this.log('error', message, detail);
    this.logger.error(messageBody);
  }

  warn(message: string) {
    this.logger.warn(message);
  }

  log(level: Level, message: string, detail: any) {
    return {
      timestamp: new Date().toISOString(),      
      spanId: '',
      severity: level.toUpperCase(),
      env: process.env.NODE_ENV ? process.env.NODE_ENV.toLowerCase() : '',
      type: 'bcl',  
      message: message,
      responseTime: detail?.responseTime || '',
      payload: detail,
    };
  }
}
