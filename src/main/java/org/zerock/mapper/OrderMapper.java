package org.zerock.mapper;


import java.util.ArrayList;

import org.pay.domain.OrderVO;
import org.pay.domain.KakaoPayApprovalVO;


public interface OrderMapper {
	
	// payment
	public void AddOrder(OrderVO ovo);
	
	public void AddOrderApproval(KakaoPayApprovalVO kvo);
	
	public ArrayList<OrderVO> PaymentList(String id);
	
	
	// wishlist
	public void WishInsert(OrderVO ovo);
	
	public ArrayList<OrderVO> WishList(String uid);
	
	public int WishDelete(int w_num);
	
}
