from django.contrib import admin
from .models import Question
from .models import Choice

# default form style for admin
# admin.site.register(Question)
# admin.site.register(Choice)

# customize the admin form
class ChoiceInline(admin.TabularInline):        
    model = Choice
    extra = 3

class QuestionAdmin(admin.ModelAdmin):
    list_display = ('question_text', 'pub_date', 'was_published_recently')
    list_filter = ['pub_date']
    search_fields = ['question_text']

    fieldsets = [
        (None,               {'fields': ['question_text']}),
        ('Date information', {'fields': ['pub_date']}),
    ]
    inlines = [ChoiceInline]

admin.site.register(Question, QuestionAdmin)