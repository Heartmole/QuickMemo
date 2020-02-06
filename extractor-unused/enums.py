from enum import Enum, IntEnum

class QuickMemoObjectTypes(IntEnum):
	TEXT = 0
	IMAGE = 1
	# UNKNOWN = 2
	VOICE = 3
	VIDEO = 4
	LIST = 5
	DRAWING = 6

class QuickMemoStyleTypes(IntEnum):
	NORMAL = 0
	STRIPPED = 1

class QuickMemoFonts(Enum):
	ROBOTO   = ("Roboto", "fonts/roboto.css")
	LG_SMART = ("LG Smart", "fonts/lg.css")
	TRAVEL   = ("Travel", "fonts/travel.css")
	COFFEE   = ("Coffee", "fonts/coffee.css")
