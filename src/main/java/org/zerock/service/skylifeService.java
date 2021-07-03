package org.zerock.service;

import org.apache.tomcat.jni.User;
import org.zerock.domain.skylifeVO;

public interface skylifeService {
	public void register(skylifeVO skylifevo);
	public int idCheck(String id);
	public skylifeVO Login(skylifeVO id)throws Exception;
<<<<<<< HEAD
	public void memUpdate(skylifeVO vo) throws Exception;
=======

>>>>>>> ab43326f0e0a83c579f61464bbcdb6489b375e48
}
