from datetime import datetime

class QuickMemoConverter:
	"""
	Utility class to convert different types in QuickMemo metadata.
	"""

	@staticmethod
	def color(color):
		"""
		Converts a color specified as a number, to a rgba CSS attribute.
		"""
		color = color if color > 0 else color + 2**32
		blue  = color % 256
		color = color // 256
		green = color % 256
		color = color // 256
		red   = color % 256
		color = color // 256
		return "rgba({}, {}, {}, {})".format(red, green, blue, color / 255)

	@staticmethod
	def date(timestamp):
		"""
		Converts a timestamp to a Python datetime.
		"""
		return datetime.fromtimestamp(timestamp / 1000)

if __name__ == '__main__':
	print(QuickMemoConverter.color(-1))           # rgba(255, 255, 255, 1.0)
	print(QuickMemoConverter.color(-6764040))     # rgba(152, 201, 248, 1.0)
	print(QuickMemoConverter.color(-16777216))    # rgba(0, 0, 0, 1.0)
	print(QuickMemoConverter.date(1577169411138)) # 2019-12-24 01:36:51.138000
	print(QuickMemoConverter.date(1577209224636)) # 2019-12-24 12:40:24.636000
