package me.chromuim.cinematic_clean.domain.executor;

import io.reactivex.Scheduler;

public interface OnMainThreadExecutor {

  Scheduler getScheduler();
}
