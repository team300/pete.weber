<%@page contentType="text/html; charset=Windows-31J"%>
<%@page import="java.util.*"%>

<html>
<body>

<h2>EL�̃e�X�g</h2>

<%
   List list = new ArrayList();
   list.add("list0");
   list.add("list1");
   list.add("list2");

   String[] array = new String[]{
      "array0",
      "array1",
      "array2"
   };

   Map map = new HashMap();
   map.put("keyA", "mapA");
   map.put("keyB", "mapB");
   map.put("keyC", "mapC");
   
   request.setAttribute("list", list);
   request.setAttribute("array", array);
   request.setAttribute("map", map);
%>


<p>���X�g���� ${list[2]}

<p>�z�񂩂� ${array[2]}

<p>�}�b�v���� ${map["keyA"]} / �����OK ${map.keyA}


</body>
</html>
