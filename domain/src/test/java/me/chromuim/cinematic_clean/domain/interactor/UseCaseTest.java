package me.chromuim.cinematic_clean.domain.interactor;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import io.reactivex.Observable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.TestScheduler;
import me.chromuim.cinematic_clean.domain.executor.OnBackgroundExecutor;
import me.chromuim.cinematic_clean.domain.executor.OnMainThreadExecutor;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class UseCaseTest {

  private UseCaseMock mUseCaseMock;


  private DisposableObserverMock<Object> mDisposableObserverMock;

  @Mock
  OnMainThreadExecutor mOnMainThreadExecutor;

  @Mock
  OnBackgroundExecutor mOnBackgroundExecutor;

  @Rule
  public ExpectedException mExpected = ExpectedException.none();


  @Before
  public void setup() {
    MockitoAnnotations.initMocks(this);
    mUseCaseMock = new UseCaseMock(mOnBackgroundExecutor, mOnMainThreadExecutor);
    mDisposableObserverMock = new DisposableObserverMock<>();
    when(mOnMainThreadExecutor.getScheduler()).thenReturn(new TestScheduler());

  }

  @Test
  public void useCaseDisposableObservers() {
    mUseCaseMock.execute(mDisposableObserverMock, Params.EMPTY);
    assertThat(mDisposableObserverMock.isDisposed()).isFalse();
    mUseCaseMock.dispose();
    assertThat(mDisposableObserverMock.isDisposed()).isTrue();

  }

  @Test
  public void testUseCaseWontExecuteWithNullObserver() {
    mExpected.expect(NullPointerException.class);
    mUseCaseMock.execute(null, Params.EMPTY);
  }


  private static class UseCaseMock extends UseCase<Object, Params> {

    UseCaseMock(OnBackgroundExecutor onBackgroundExecutor, OnMainThreadExecutor onMainThreadExecutor) {
      super(onBackgroundExecutor, onMainThreadExecutor);
    }

    @Override
    Observable<Object> buildUseCase(Params params) {
      return Observable.empty();
    }

    @Override
    public void execute(DisposableObserver<Object> disposableObserver, Params params) {
      super.execute(disposableObserver, params);
    }
  }

  private static class DisposableObserverMock<T> extends DisposableObserver<T> {

    private int dummValue = 0;

    @Override
    public void onNext(T value) {
      dummValue++;
    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onComplete() {

    }
  }

  private static class Params {

    private static Params EMPTY = new Params();

    private Params() {
    }
  }

}