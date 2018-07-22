package org.goldenage.com.goldenage

class LifeEventController
{
    var _lifeEvents : ArrayList<LifeEvent>? = null

    fun getLifeEvents() : ArrayList<LifeEvent>?
    {
        return _lifeEvents
    }

    /**
     * 이벤트를 정렬함
     */
    fun alignmentEvents()
    {
        if (_lifeEvents == null)
            return

        _lifeEvents!!.sortWith(object: Comparator<LifeEvent>{
            override fun compare(o1: LifeEvent?, o2: LifeEvent?): Int = when{
                o1!!.age < o2!!.age -> 1
                o1!!.month > o2!!.month -> 0
                else -> -1
            }
        })
    }

    /**
     * 로컬에 저장된 이벤트를 불러온다
     * @TODO minjun.ha 로드 테스트 코드 추가함
     * @return List<LifeEvent>? 로드된 이벤트 목록
     */
    public fun loadLifeEvents()
    {
        addLifeEvent(LifeEvent(1,10,"내가 태어남", 100))
        addLifeEvent(LifeEvent(3,2,"검도 메달 땀", 60))
        addLifeEvent(LifeEvent(10,2,"초등학교 졸업", 70))
    }

    /**
     * 이벤트를 추가한다
     * @param LifeEvent 이벤트 데이터
     */
    public fun addLifeEvent(lifeEvent : LifeEvent)
    {
        if (_lifeEvents == null)
        {
            _lifeEvents = arrayListOf()
        }
        _lifeEvents!!.add(lifeEvent)
        alignmentEvents()
    }

    /**
     * 이벤트를 삭제한다
     * @param Int 삭제할 인덱스
     */
    public fun removeEvent(position : Int)
    {
        if (_lifeEvents != null && !_lifeEvents!!.isEmpty())
        {
            _lifeEvents!!.removeAt(position)
        }
    }

}