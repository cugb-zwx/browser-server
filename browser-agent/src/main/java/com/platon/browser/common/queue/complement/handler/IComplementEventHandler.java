package com.platon.browser.common.queue.complement.handler;

import com.lmax.disruptor.EventHandler;
import com.platon.browser.common.queue.complement.event.ComplementEvent;
import org.springframework.retry.annotation.Retryable;


/**
 * 区块事件处理器接口
 */
public interface IComplementEventHandler extends EventHandler<ComplementEvent> {

    @Override
    @Retryable(value = Exception.class, maxAttempts = Integer.MAX_VALUE)
    void onEvent(ComplementEvent event, long sequence, boolean endOfBatch) throws Exception;
}