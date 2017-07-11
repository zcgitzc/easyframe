package com.zark.easyframe.biz.common.bo;

public interface SequenceValBo {
	/**
	 * 获取序列的下一个值
	 * 
	 * @param sequenceName
	 *            序列名称
	 * @return 该序列的nextVal值
	 */
	Long getNextVal(String sequenceName);

	/**
	 * 批量获取序列的下一组值
	 * 
	 * @param sequenceName
	 *            序列名称
	 * @param batchSize
	 *            组大小
	 * @return 该序列的nextVal值
	 */
	Long getNextBatchVal(String sequenceName, int batchSize);
}
