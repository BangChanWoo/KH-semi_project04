<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="notice.vo.Notice" %>
<%
    ArrayList<Notice> volist = (ArrayList<Notice>) request.getAttribute("volist");
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
            if (volist.size() > 0) {
                for (int i = 0; i < volist.size(); i++) {
        %>
        <tr onclick="ShowDetail(<%=volist.get(i).getNotice_num()%>)">
            <td>
            	<%=volist.get(i).getNotice_num()%>
            </td>
            <td>
                <%=volist.get(i).getNotice_title()%>
            </td>
            <td>
                <%=volist.get(i).getNotice_content()%>
            </td>
            <td>
                <%=volist.get(i).getNotice_time()%>
            </td>
        </tr>
        <%
            }
        } else {	
        %>
        <tr>
            <td colspan="5">게시글이 없습니다.</td>
        </tr>
        <%
            }
        %>
    </table>
    <button onclick="location.ahref='list.do'">게시물목록보기</button>
    <br/>
    <br/>
    <button onclick="location.href='main.jsp'">홈으로 이동</button>
</div>

</body>
</html>


