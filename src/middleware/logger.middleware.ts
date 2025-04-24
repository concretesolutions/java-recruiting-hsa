import { Injectable, NestMiddleware } from '@nestjs/common';
import { Request, Response, NextFunction } from 'express';

@Injectable()
export class LoggerMiddleware implements NestMiddleware {
  use(req: Request, res: Response, next: NextFunction) {
    console.log('Request...: ', req.body);
    const originalSend = res.send;
    
    // Override the send function to intercept the response body
    res.send = function (body) {
      console.log('Response body:', body);
      return originalSend.call(this, body);
    };
    
    next();
  }
}