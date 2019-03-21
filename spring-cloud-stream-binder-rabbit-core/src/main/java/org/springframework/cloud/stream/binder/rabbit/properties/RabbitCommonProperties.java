/*
 * Copyright 2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.cloud.stream.binder.rabbit.properties;

import org.hibernate.validator.constraints.Range;

import org.springframework.amqp.core.ExchangeTypes;

/**
 * @author Gary Russell
 * @since 1.2
 *
 */
public abstract class RabbitCommonProperties {

	public static final String DEAD_LETTER_EXCHANGE = "DLX";

	/**
	 * type of exchange to declare (if necessary, and declareExchange is true)
	 */
	private String exchangeType = ExchangeTypes.TOPIC;

	/**
	 * whether to declare the exchange
	 */
	private boolean declareExchange = true;

	/**
	 * whether to declare the exchange as durable
	 */
	private boolean exchangeDurable = true;

	/**
	 * whether to declare the exchange as auto-delete
	 */
	private boolean exchangeAutoDelete = false;

	/**
	 * whether a delayed message exchange should be used
	 */
	private boolean delayedExchange = false;

	/**
	 * whether to bind a queue (or queues when partitioned) to the exchange
	 */
	private boolean bindQueue = true;

	/**
	 * routing key to bind (default # for non-partitioned, destination-instanceIndex for partitioned)
	 */
	private String bindingRoutingKey;

	/**
	 * default time to live to apply to the queue when declared (ms)
	 */
	private Integer ttl;

	/**
	 * how long before an unused queue is deleted (ms)
	 */
	private Integer expires;

	/**
	 * maximum number of messages in the queue
	 */
	private Integer maxLength;

	/**
	 * maximum number of total bytes in the queue from all messages
	 */
	private Integer maxLengthBytes;

	/**
	 * maximum priority of messages in the queue (0-255)
	 */
	private Integer maxPriority;

	/**
	 * name of the DLQ - default is prefix+destination.dlq
	 */
	private String deadLetterQueueName;

	/**
	 * a DLX to assign to the queue; if autoBindDlq is true, defaults to 'prefix+DLX'
	 */
	private String deadLetterExchange;

	/**
	 * a dead letter routing key to assign to that queue; if autoBindDlq is true, defaults to destination
	 */
	private String deadLetterRoutingKey;

	/**
	 * default time to live to apply to the dead letter queue when declared (ms)
	 */
	private Integer dlqTtl;

	/**
	 * how long before an unused dead letter queue is deleted (ms)
	 */
	private Integer dlqExpires;

	/**
	 * maximum number of messages in the dead letter queue
	 */
	private Integer dlqMaxLength;

	/**
	 * maximum number of total bytes in the dead letter queue from all messages
	 */
	private Integer dlqMaxLengthBytes;

	/**
	 * maximum priority of messages in the dead letter queue (0-255)
	 */
	private Integer dlqMaxPriority;

	/**
	 * if a DLQ is declared, a DLX to assign to that queue; default none
	 */
	private String dlqDeadLetterExchange;

	/**
	 * if a DLQ is declared, a dead letter routing key to assign to that queue; default none
	 */
	private String dlqDeadLetterRoutingKey;

	/**
	 * true to automatically bind a dead letter queue to a DLX
	 */
	private boolean autoBindDlq;

	/**
	 * prefix for elements declared in RabbitMQ (exchanges, queues)
	 */
	private String prefix = "";

	/**
	 * True if the queue is provisioned as a lazy queue.
	 */
	private boolean lazy;

	/**
	 * True if the DLQ is provisioned as a lazy queue.
	 */
	private boolean dlqLazy;

	public String getExchangeType() {
		return this.exchangeType;
	}

	public void setExchangeType(String exchangeType) {
		this.exchangeType = exchangeType;
	}

	public boolean isDeclareExchange() {
		return this.declareExchange;
	}

	public void setDeclareExchange(boolean declareExchange) {
		this.declareExchange = declareExchange;
	}

	public boolean isExchangeDurable() {
		return this.exchangeDurable;
	}

	public void setExchangeDurable(boolean exchangeDurable) {
		this.exchangeDurable = exchangeDurable;
	}

	public boolean isExchangeAutoDelete() {
		return this.exchangeAutoDelete;
	}

	public void setExchangeAutoDelete(boolean exchangeAutoDelete) {
		this.exchangeAutoDelete = exchangeAutoDelete;
	}

	public boolean isDelayedExchange() {
		return this.delayedExchange;
	}

	public void setDelayedExchange(boolean delayedExchange) {
		this.delayedExchange = delayedExchange;
	}

	public boolean isBindQueue() {
		return this.bindQueue;
	}

	public void setBindQueue(boolean bindQueue) {
		this.bindQueue = bindQueue;
	}

	public String getBindingRoutingKey() {
		return this.bindingRoutingKey;
	}

	public void setBindingRoutingKey(String routingKey) {
		this.bindingRoutingKey = routingKey;
	}

	public Integer getTtl() {
		return this.ttl;
	}

	public void setTtl(Integer ttl) {
		this.ttl = ttl;
	}

	public Integer getExpires() {
		return this.expires;
	}

	public void setExpires(Integer expires) {
		this.expires = expires;
	}

	public Integer getMaxLength() {
		return this.maxLength;
	}

	public void setMaxLength(Integer maxLength) {
		this.maxLength = maxLength;
	}

	public Integer getMaxLengthBytes() {
		return this.maxLengthBytes;
	}

	public void setMaxLengthBytes(Integer maxLengthBytes) {
		this.maxLengthBytes = maxLengthBytes;
	}

	@Range(min = 0, max = 255)
	public Integer getMaxPriority() {
		return this.maxPriority;
	}

	public void setMaxPriority(Integer maxPriority) {
		this.maxPriority = maxPriority;
	}

	public String getDeadLetterQueueName() {
		return this.deadLetterQueueName;
	}

	public void setDeadLetterQueueName(String deadLetterQueueName) {
		this.deadLetterQueueName = deadLetterQueueName;
	}

	public String getDeadLetterExchange() {
		return this.deadLetterExchange;
	}

	public void setDeadLetterExchange(String deadLetterExchange) {
		this.deadLetterExchange = deadLetterExchange;
	}

	public String getDeadLetterRoutingKey() {
		return this.deadLetterRoutingKey;
	}

	public void setDeadLetterRoutingKey(String deadLetterRoutingKey) {
		this.deadLetterRoutingKey = deadLetterRoutingKey;
	}

	public Integer getDlqTtl() {
		return this.dlqTtl;
	}

	public void setDlqTtl(Integer dlqTtl) {
		this.dlqTtl = dlqTtl;
	}

	public Integer getDlqExpires() {
		return this.dlqExpires;
	}

	public void setDlqExpires(Integer dlqExpires) {
		this.dlqExpires = dlqExpires;
	}

	public Integer getDlqMaxLength() {
		return this.dlqMaxLength;
	}

	public void setDlqMaxLength(Integer dlqMaxLength) {
		this.dlqMaxLength = dlqMaxLength;
	}

	public Integer getDlqMaxLengthBytes() {
		return this.dlqMaxLengthBytes;
	}

	public void setDlqMaxLengthBytes(Integer dlqMaxLengthBytes) {
		this.dlqMaxLengthBytes = dlqMaxLengthBytes;
	}

	public Integer getDlqMaxPriority() {
		return this.dlqMaxPriority;
	}

	public void setDlqMaxPriority(Integer dlqMaxPriority) {
		this.dlqMaxPriority = dlqMaxPriority;
	}

	public String getDlqDeadLetterExchange() {
		return this.dlqDeadLetterExchange;
	}

	public void setDlqDeadLetterExchange(String dlqDeadLetterExchange) {
		this.dlqDeadLetterExchange = dlqDeadLetterExchange;
	}

	public String getDlqDeadLetterRoutingKey() {
		return this.dlqDeadLetterRoutingKey;
	}

	public void setDlqDeadLetterRoutingKey(String dlqDeadLetterRoutingKey) {
		this.dlqDeadLetterRoutingKey = dlqDeadLetterRoutingKey;
	}

	public boolean isAutoBindDlq() {
		return autoBindDlq;
	}

	public void setAutoBindDlq(boolean autoBindDlq) {
		this.autoBindDlq = autoBindDlq;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public boolean isLazy() {
		return this.lazy;
	}

	public void setLazy(boolean lazy) {
		this.lazy = lazy;
	}

	public boolean isDlqLazy() {
		return this.dlqLazy;
	}

	public void setDlqLazy(boolean dlqLazy) {
		this.dlqLazy = dlqLazy;
	}

}
