import html.parser

from .converter import QuickMemoConverter

class QuickMemoTextNode:
	"""
	Represents a text node from a QuickMemo+ file.
	"""

	def __init__(self, html):
		self.align = None
		self.dir   = None
		self.color = None
		self.html  = html
		self.style = []

	def parse(self):
		pass

	def to_html(self):
		# Prepare auxiliar variables
		styles = []
		if self.align:
			styles.append('text-align: {0}'.format(self.align))
		if self.color:
			styles.append('color: {0}'.format(self.color))
		# Parse output
		out = '<div dir="{0}" style="{1}"{2}></div>'
		return out.format(self.dir, '; '.join(styles), text)
