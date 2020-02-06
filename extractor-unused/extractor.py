"""
import sys
import re

from enums import QuickMemoFonts

class QuickMemoExtractor:
	"/""
	QuickMemo+ extractor. 
	"/""

	def __init__(self, args):
		# Initialize values
		self.args = args
		self.success = 0
		self.failure = 0
		self.selectfont = False
		# Parse arguments
		self.parse_arguments()

	def parse_arguments(self):
		# Print usage
		if len(self.args) < 2:
			self.usage()
		# Check arguments
		for arg in self.args:
			if arg.startswith('-'):
				self.check_option(arg)
			else:
				self.check_argument(arg)

	def check_option(self, arg):
		# Print version information
		if arg in ['-v', '--version']:
			self.version()
		# Print usage
		if arg in ['-h', '--help']:
			self.usage()
		# Wait for font input
		if arg in ['-f', '--font']:
			self.selectfont = True
		# In other cases, throw error
		print('Unknown option: {0}'.format(arg))
		sys.exit(1)

	def check_argument(self, arg):
		pass

	def usage(self):
		"/""
		Prints the usage of the application and the list of options and
		arguments for the application.
		"/""
		print('Usage:')
		print('  {0} [options] [file.lqm] ...'.format(self.args[0]))
		print('List of options:')
		print('  -f <font>         select desired font for the output')
		print('  -h, --help        display this message and quit')
		print('  -v, --version     display version info and quit')
		print('Supported fonts:')
		for name in QuickMemoFonts.__members__:
			print('  {0}'.format(QuickMemoFonts[name].value[0]))
		sys.exit()

	def version(self):
		"/""
		Prints the version information for the QuickMemo+ Extractor and quit.
		"/""
		print('QuickMemo+ Extractor 1.0')
		sys.exit()

if __name__ == "__main__":
    QuickMemoExtractor(sys.argv)
"""

import tkinter as tk

window = tk.Tk()
window.title('QuickMemo+ Extractor')

label = tk.Label(window, text='Font:')
label.pack()

font = tk.StringVar(value=0)

roboto = tk.Radiobutton(window, text='Roboto', variable=font, value=1)
roboto.pack()

lgsmart = tk.Radiobutton(window, text='LG Smart', variable=font, value=2)
lgsmart.pack()

travel = tk.Radiobutton(window, text='Travel', variable=font, value=2)
travel.pack()

coffee = tk.Radiobutton(window, text='Coffee', variable=font, value=2)
coffee.pack()

btnfile = tk.Button(window, text='Load from file...')
btnfile.pack()

btnfolder = tk.Button(window, text='Load from folder...')
btnfolder.pack()

window.mainloop()
