import { TestBed } from '@angular/core/testing';

import { RestuarantServicesService } from './restuarant-services.service';

describe('RestuarantServicesService', () => {
  let service: RestuarantServicesService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RestuarantServicesService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
