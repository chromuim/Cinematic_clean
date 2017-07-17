package me.chromuim.cinematic_clean.domain.interactor;

import static com.google.common.base.Preconditions.checkNotNull;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import me.chromuim.cinematic_clean.domain.executor.OnBackgroundExecutor;
import me.chromuim.cinematic_clean.domain.executor.OnMainThreadExecutor;

public abstract class UseCase<T, Params> {

  private final OnBackgroundExecutor mOnBackgroundExecutor;

  private final OnMainThreadExecutor mOnMainThreadExecutor;

  private final CompositeDisposable mCompositeDisposable;

  UseCase(OnBackgroundExecutor onBackgroundExecutor, OnMainThreadExecutor onMainThreadExecutor) {
    mOnBackgroundExecutor = onBackgroundExecutor;
    mOnMainThreadExecutor = onMainThreadExecutor;
    mCompositeDisposable = new CompositeDisposable();
  }

  abstract Observable<T> buildUseCase(Params params);

  public void execute(DisposableObserver<T> disposableObserver, Params params) {
    checkNotNull(disposableObserver);
    Observable<T> observable = buildUseCase(params)
        .subscribeOn(Schedulers.from(mOnBackgroundExecutor))
        .observeOn(mOnMainThreadExecutor.getScheduler());

    addDisposable(observable.subscribeWith(disposableObserver));

  }

  public void dispose() {
    if (!mCompositeDisposable.isDisposed()) {
      mCompositeDisposable.dispose();
    }
  }

  private void addDisposable(Disposable disposable) {
    checkNotNull(disposable);
    checkNotNull(mCompositeDisposable);
    mCompositeDisposable.add(disposable);
  }
}
