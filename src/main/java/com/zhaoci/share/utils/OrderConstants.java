package com.zhaoci.share.utils;

public class OrderConstants {
	private OrderConstants() {
		
	}
	/** 
	 * 订单类型
	 * 10、共享临停
	 * 11、临停缴费
	 * 12、代泊
	 * 1、3月租
	 * 14、产权
	 * 15、加油卡
	 * */
	public static final String ORDER_TYPE_TEMPORARY_SHARE = "10";
	
	public static final String ORDER_TYPE_TEMPORARY = "11";
	
	public static final String ORDER_TYPE_PARK = "12";
	
	public static final String ORDER_TYPE_MONTHLY = "13";
	
	public static final String ORDER_TYPE_EQUITY = "14";
	/**
	 * 根据orderType获取orderTypeName
	 */
	public static String getOrderTypeName(String orderType){
		String orderTypeName = null;
		if(orderType !=null && orderType !=""){
			if(OrderConstants.ORDER_TYPE_TEMPORARY_SHARE.equals(orderType)){
				orderTypeName = "共享临停";
			}else if(OrderConstants.ORDER_TYPE_TEMPORARY.equals(orderType)){
				orderTypeName = "临停缴费";
			}else if(OrderConstants.ORDER_TYPE_PARK.equals(orderType)){
				orderTypeName = "代泊";
			}else if(OrderConstants.ORDER_TYPE_MONTHLY.equals(orderType)){
				orderTypeName = "月租";
			}else if(OrderConstants.ORDER_TYPE_EQUITY.equals(orderType)){
				orderTypeName = "产权";
			}
		}else{
			orderTypeName = "不存在订单类型";
		}
		return orderTypeName;
	}
	/**
	 * 订单状态
	 * 1、已预约 bespoke
	 * 2、已接车 pickcar
	 * 3、已交车putcar
	 * 4、已停车parked
	 * 5、已完成finished
	 * 6、已取车getedcar
	 * 7、已拒绝rejected
	 * 8、待取车waiting_getcar
	 * 9、提车中getingcar
	 * 10、未付款 unpay
	 * 11、已付款 paid
	 * 12、已取消 canceled
	 * */
	public static final String ORDER_STATUS_BESPOKE = "1";
	
	public static final String ORDER_STATUS_PICKCAR = "2";

	public static final String ORDER_STATUS_PUTCAR = "3";

	public static final String ORDER_STATUS_PARKED = "4";
	
	public static final String ORDER_STATUS_FINISHED = "5";

	public static final String ORDER_STATUS_GETEDCAR = "6";
	
	public static final String ORDER_STATUS_REJECTED = "7";

	public static final String ORDER_STATUS_WAITING_GETCAR = "8";

	public static final String ORDER_STATUS_GETTINGCAR = "9";

	public static final String ORDER_STATUS_UNPAY = "10";

	public static final String ORDER_STATUS_PAID = "11";
	
	public static final String ORDER_STATUS_CANCELED = "12";
	/**
	 * 根据orderStatus获取orderStatusName
	 */
	public static String getOrderStatusName(String orderStatus){
		String orderStatusName = null;
		if(orderStatus !=null && orderStatus !=""){
			if(OrderConstants.ORDER_STATUS_BESPOKE.equals(orderStatus)){
				orderStatusName = "已预约";
			}else if(OrderConstants.ORDER_STATUS_PICKCAR.equals(orderStatus)){
				orderStatusName = "已接车";
			}else if(OrderConstants.ORDER_STATUS_PUTCAR.equals(orderStatus)){
				orderStatusName = "已交车";
			}else if(OrderConstants.ORDER_STATUS_PARKED.equals(orderStatus)){
				orderStatusName = "已停车";
			}else if(OrderConstants.ORDER_STATUS_FINISHED.equals(orderStatus)){
				orderStatusName = "已完成";
			}else if(OrderConstants.ORDER_STATUS_GETEDCAR.equals(orderStatus)){
				orderStatusName = "已取车";
			}else if(OrderConstants.ORDER_STATUS_REJECTED.equals(orderStatus)){
				orderStatusName = "已拒绝";
			}else if(OrderConstants.ORDER_STATUS_WAITING_GETCAR.equals(orderStatus)){
				orderStatusName = "待取车";
			}else if(OrderConstants.ORDER_STATUS_GETTINGCAR.equals(orderStatus)){
				orderStatusName = "提车中";
			}else if(OrderConstants.ORDER_STATUS_UNPAY.equals(orderStatus)){
				orderStatusName = "未付款";
			}else if(OrderConstants.ORDER_STATUS_PAID.equals(orderStatus)){
				orderStatusName = "已付款";
			}else if(OrderConstants.ORDER_STATUS_CANCELED.equals(orderStatus)){
				orderStatusName = "已取消";
			}
		}else{
			orderStatusName = "不存在该订单状态";
		}
		return orderStatusName;
	}
}
