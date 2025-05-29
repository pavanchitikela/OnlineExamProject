import { TestBed } from '@angular/core/testing';

import { UserOptionService } from './user-option.service';

describe('UserOptionService', () => {
  let service: UserOptionService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UserOptionService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
