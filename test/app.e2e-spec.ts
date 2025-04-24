import { Test, TestingModule } from '@nestjs/testing';
import { INestApplication } from '@nestjs/common';
import * as request from 'supertest';
import { AppModule } from './../src/app.module';

describe('AppController (e2e)', () => {
  let app: INestApplication;

  const mockCategories = [{
    id: "MOB",
    name: "MOBILE_MARKET",
    subcategories: [
      {
        id: "video-games",
        name: "Video Games",
        relevance: 150,
        subcategories: [
          {
            id: "nintendo",
            name: "Nintendo",
            smallImageUrl: "https://example.com/image.jpg",
            subcategories: [
              {
                id: "switch",
                name: "Switch",
                relevance: 422
              }
            ]
          }
        ]
      }
    ]
  }];

  const mockCoupons = [
    {
      id: "COUPON_1",
      description: "50% Discount",
      seller: "Crazy Seller",
      image: "https://example.com/image1.jpg",
      expiresAt: "2045-12-01"
    },
    {
      id: "COUPON_2",
      description: "5% Discount",
      seller: "The Seller",
      image: "https://example.com/image2.jpg",
      expiresAt: "2042-12-25"
    }
  ];

  const mockDashboard = {
    categories: mockCategories,
    coupons: mockCoupons
  };

  beforeAll(async () => {
    const moduleFixture: TestingModule = await Test.createTestingModule({
      imports: [AppModule],
    })
    .overrideProvider('CategoryRepository')
    .useValue({
      findAll: jest.fn().mockResolvedValue(mockCategories)
    })
    .overrideProvider('CouponRepository')
    .useValue({
      findAll: jest.fn().mockResolvedValue(mockCoupons)
    })
    .compile();

    app = moduleFixture.createNestApplication();
    await app.init();
  });

  afterAll(async () => {
    await app.close();
  });

  it('/ (GET)', () => {
    return request(app.getHttpServer())
      .get('/')
      .expect(200)
      .expect('Hello World!');
  });

  describe('/categories', () => {
    it('GET /top should return top categories', () => {
      return request(app.getHttpServer())
        .get('/category/top?limit=5')
        .expect(200)
        .expect(res => {
          expect(Array.isArray(res.body)).toBeTruthy();
          expect(res.body.length).toBeLessThanOrEqual(5);
        });
    });

    it('GET /notop should return non-top categories', () => {
      return request(app.getHttpServer())
        .get('/category/notop?from=5')
        .expect(200)
        .expect(res => {
          expect(Array.isArray(res.body)).toBeTruthy();
        });
    });
  });

  describe('/coupons', () => {
    it('GET /notexpired should return non-expired coupons', () => {
      return request(app.getHttpServer())
        .get('/coupon/notexpired')
        .expect(200)
        .expect(res => {
          expect(Array.isArray(res.body)).toBeTruthy();
          expect(res.body.every(coupon => 
            new Date(coupon.expiresAt) > new Date()
          )).toBeTruthy();
        });
    });
  });

  describe('/dashboard', () => {
    it('GET / should return dashboard data', () => {
      return request(app.getHttpServer())
        .get('/dashboard?limit=5')
        .expect(200)
        .expect(res => {
          expect(res.body).toHaveProperty('categories');
          expect(res.body).toHaveProperty('coupons');
          expect(Array.isArray(res.body.categories)).toBeTruthy();
          expect(Array.isArray(res.body.coupons)).toBeTruthy();
        });
    });
  });
});
