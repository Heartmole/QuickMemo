class QuickMemoCheckboxNode:
    """
    Represents a checked list item from a QuickMemo+ file.
    """

    def __init__(self, html):
        self.checked = False

    def parse(self):
        pass

    def to_html(self):
        """
        Format the checkbox node as HTML source code.
        """
        # Prepare auxiliar variables
        check_id   = 'checkbox-{0}'.format(self.id)
        is_checked = ' checked="checked"' if self.checked else ''
        check_text = QuickMemoCheckboxNode(self.text).to_html()
        # Parse output
        out = '<input type="checkbox" id="{0}"{1}><label for="{0}">{2}</label>'
        return out.format(check_id, is_checked, check_text)
