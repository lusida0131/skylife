package org.zerock.mapper;


import java.util.ArrayList;

import org.pay.domain.OrderVO;
import org.pay.domain.KakaoPayApprovalVO;


public interface OrderMapper {
	
	// payment
	public void AddOrder(OrderVO ovo);
	
	// 보류
	public void AddOrderApproval(KakaoPayApprovalVO kvo);
	
	// 회원 결제 리스트
	public ArrayList<OrderVO> PaymentList(String id);
	
	// 회원 결제 리스트 - 상세보기
	public OrderVO PaymentDetail(int pay_num);

	// 총회원 매출 조회
	public ArrayList<OrderVO> moneylist();
	
	// 장바구니 등록
	public void WishInsert(OrderVO ovo);
	
	// 장바구니 리스트
	public ArrayList<OrderVO> WishList(String uid);
	
	// 장바구니 삭제
	public int WishDelete(int w_num);
	
}
