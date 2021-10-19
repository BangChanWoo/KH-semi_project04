<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="notice.vo.Notice" %>
<%
    Notice noticeVo = (Notice) request.getAttribute("noticeVo");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <script type="text/javascript">
        function ShowDetail(notice_num) {
            location.href = "detail.do?num=" + notice_num;
        }

        $(document).ready(function () {
            $('tr').hover(function () {
                $(this).css('color', 'blue');
            }, function () {
                $(this).css('color', 'black');
            });
        });
    </script>
</head>
<body>
<div id="table">
    <table>
        <tr>
            <td>글번호</td>
            <td>글제목</td>
            <td>글내용</td>
            <td>작성자</td>
            <td>작성일자</td>
        </tr>
        <%
            if (noticeVo != null) {
        %>
        <tr onclick="ShowDetail(<%=noticeVo.getNotice_num()%>)">
            <td>
            	<%=noticeVo.getNotice_num()%>
            </td>
            <td>
                <%=noticeVo.getNotice_title()%>
            </td>
            <td>
                <%=noticeVo.getNotice_content()%>
            </td>
            <td>
                <%=noticeVo.getNotice_time()%>
            </td>
        </tr>
        <%
        } else {	
        %>
        <tr>
            <td colspan="5">게시글이 없습니다.</td>
        </tr>
        <%
            }
        %>
    </table>
    <button onclick="location.href='usernotice'">게시물목록보기</button>
    <br/>
    <br/>
    <button onclick="location.href='main'">홈으로 이동</button>
</div>

</body>
</html>


