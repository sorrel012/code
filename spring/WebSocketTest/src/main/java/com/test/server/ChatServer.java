package com.test.server;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.google.gson.Gson;
import com.test.domain.ChatDTO;


@ServerEndpoint("/chatserver.do")
public class ChatServer {
	
	private static List<Session> sessionList;
	
	static {
		sessionList = new ArrayList<Session>();
	}
	
	@OnOpen
	public void handleOpen(Session session) {
		System.out.println("연결 성공");
		sessionList.add(session);
	}
	
	@OnMessage
	public void handleMessage(String msg, Session session) {
		
		System.out.println(msg);
		
		//JSON <- (변환) -> Java Object
		// - GSON
		
		Gson gson = new Gson();
		
		ChatDTO dto = gson.fromJson(msg, ChatDTO.class);
		
		if (dto.getCode().equals("1")) {
			
			//새로운 유저가 접속했습니다. > 모든 사람에게 알림 (현재 접속자 제외)
			for(Session s : sessionList) {
				if(s != session) {
					try {
						s.getBasicRemote().sendText(msg);
						
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			
		} else if (dto.getCode().equals("2")) {

			//누군가가 퇴장 > 나머지 사람들에게 알려줌
			sessionList.remove(session); //서버 측에서의 퇴장
			
			for(Session s : sessionList) {
				
				try {
					s.getBasicRemote().sendText(msg);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
			
		} else if (dto.getCode().equals("3")) {
			
			//대화 메시지를 모두에게 전달
			for (Session s : sessionList) {
				if(s != session) {
					
					try {
						s.getBasicRemote().sendText(msg);
					} catch (Exception e) {
						e.printStackTrace();
					}
					
				}
			}
		} else if (dto.getCode().equals("4")) {
			
			//이모티콘 메시지를 모두에게 전달
			for (Session s : sessionList) {
				if(s != session) {
					
					try {
						s.getBasicRemote().sendText(msg);
					} catch (Exception e) {
						e.printStackTrace();
					}
					
				}
			}
		}
		
	}
	
	@OnClose
	public void handleClose() {
		
	}
	
	@OnError
	public void handleError(Throwable e) {
		
	}
	
}
