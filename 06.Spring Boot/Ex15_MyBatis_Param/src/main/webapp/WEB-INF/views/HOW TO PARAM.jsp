<!-- param(파라미터) 사용방법 적어놓은것. (주석처리하기엔 너무길어서) -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	방법1 : param1, param2
	<select>
		select * from 테이블명 where 컬럼=#{param1} and 컬럼=#{param2}
	</select>

방법2 : 0부터 시작하는 인덱스를 사용
	<select>
		select * from 테이블명 where 컬럼=#{0} and 컬럼=#{1}
	</select>

방법3 : 파라미터명을 그대로 사용하기 위해 @Param 어노테이션을 사용

	호출을 가장 먼저 받는 interface 추상메소드 정의시
		public void 함수명(@Param("파라미터명") String 파라미터명, .... )
	Mapper파일에서
		select * from 테이블명 where 필드명=#{파라미터명}
	으로 사용할 수 있다.

방법4 : 파라미터로 해시맵을 사용 (다음 예제에서 적용)

	호출을 가장 먼저 받는 interface 추상메소드 정의시
                       public int writeDao(Map<String, String> 파라미터명);
	Controller 파일에서
		Map<String, String> map = new HashMap<String, String>();
		map.put("item1", sName);
		map.put("item2", sContent);
	Mapper파일에서
		insert into simple_bbs (id, writer, content)
		     values (simple_bbs_seq.nextval, #{item1}, #{item2})
	으로 사용할 수 있다
	
</body>
</html>