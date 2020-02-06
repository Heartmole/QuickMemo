import json
import zipfile

from .enums import QuickMemoObjectTypes, QuickMemoStyleTypes
from .errors import QuickMemoException

class QuickMemoReader:
	"""
	QuickMemo+ reader. Uncompresses .lqm files and generates all the needed
	info for extracting.
	"""

	def __init__(self, filename):
		self.filename = filename
		# Load .lqm file (which is only a ZIP file)
		try:
			self.file = zipfile.ZipFile(filename)
		except Exception as ex:
			msg = '{0} does not exist or is not a valid .lqm file.'
			raise QuickMemoException(msg.format(filename)) from ex
		# Load memoinfo.jlqm from the .lqm file (which is just a JSON file)
		try:
			self.memoinfo = json.load(self.file.open('memoinfo.jlqm'))
		except Exception as ex:
			msg = 'Could not find memoinfo file, is {0} a valid .lqm file?'
			raise QuickMemoException(msg.format(filename)) from ex
		# Load metadata.mtd from the .lqm file (which is just a JSON file)
		try:
			self.metadata = json.load(self.file.open('metadata.mtd'))
		except Exception as ex:
			msg = 'Could not find metadata file, is {0} a valid .lqm file?'
			raise QuickMemoException(msg.format(filename)) from ex

	def process(self):
		"""
		Process the QuickMemo files to get all images, audio and video.
		"""
		pass

	def extract(self):
		"""
		Generate a HTML viewer from the processed data.
		"""
		print(self.memoinfo)
		input()
		print(self.metadata)

# TODO: uncompress .lqm => read .jlqm as JSON, .mtd as JSON, search for images and drawings, make HTML
