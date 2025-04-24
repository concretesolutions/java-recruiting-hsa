import { NestFactory } from '@nestjs/core';
import { AppModule } from './app.module';
import { WinstonLoggerService } from './shared/infrastructure/logger/winston-logger.service';
import { DocumentBuilder, SwaggerModule } from '@nestjs/swagger';
//import metadata from './metadata';

async function bootstrap() {
  const app = await NestFactory.create(AppModule, {
    logger: new WinstonLoggerService(),
  });
  const config = new DocumentBuilder()
    .setTitle('Desafio Node Accenture')
    .setDescription('Desafio técnico para evaluar el conocimiento de los aspirantes a unirse al equipo de **Backend**')
    .setVersion('1.0')   
    .build();
    
  //await SwaggerModule.loadPluginMetadata(metadata);
  const document = SwaggerModule.createDocument(app, config);
  SwaggerModule.setup('api', app, document);
  await app.listen(3000);
}
bootstrap();