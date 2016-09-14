function Table1(row, col) {
	var str = "";
	for (var i = 0; i < row; i++) {
		str = str + "<tr>";
		for (var j = 0; j < col; j++)

		{
			str = str + "<td><div></div></td>";
		}
		str = str + "</tr>";
	}
	return str;
}