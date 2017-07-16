package me.chromuim.cinematic_clean.domain.interactor;

import static org.junit.Assert.*;

import me.chromuim.cinematic_clean.domain.executor.OnBackgroundExecutor;
import me.chromuim.cinematic_clean.domain.executor.OnMainThreadExecutor;
import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class UseCaseTest {

  @Mock
  OnMainThreadExecutor mOnMainThreadExecutor;

  @Mock
  OnBackgroundExecutor mOnBackgroundExecutor;


  @Before
  public void setup() {
    MockitoAnnotations.initMocks(this);
  }

}