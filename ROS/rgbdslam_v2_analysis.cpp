#ifdef Q_NO_DATA_RELOCATION
#define Q_OBJECT_GETSTATICMETAOBJECT static const QMetaObject &getStaticMetaObject();
#else
#define Q_OBJECT_GETSTATICMETAOBJECT
#endif


#define Q_OBJECT_CHECK \
	template <typename T> inline void qt_check_for_QOBJECT_macro(const T &_q_argument) const \
	{ int i = qYouForgotTheQ_OBJECT_Macro(this, &_q_argument); i = i; }

#define Q_OBJECT \
public: \
	Q_OBJECT_CHECK \
	static const QMetaObject staticMetaObject; \
	Q_OBJECT_GETSTATICMETAOBJECT \
	virtual const QMetaObject *metaObject() const; \
	virtual void *qt_metacast(const char *); \
	QT_TR_FUNCTIONS \
	virtual int qt_metacall(QMetaObject::Call, int, void **); \
private:
	Q_DECL_HIDDEN static const QMetaObjectExtraData staticMetaObjectExtraData; \
	Q_DECL_HIDDEN static void qt_static_metacall(QObject *, QMetaObject::Call, int, void **);

template <typename T>
inline int qYouForgotTheQ_OBJECT_Macro(T, T) {return 0;}
template <typename T1, typename T2>
inline void qYouForgotTheQ_OBJECT_Macro(T1, T2) {}
