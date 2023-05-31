import { TestBed } from '@angular/core/testing';

import { RouteGuardGuard } from './route-guard.guard';

describe('RouteGuardGuard', () => {
  let guard: RouteGuardGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(RouteGuardGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
