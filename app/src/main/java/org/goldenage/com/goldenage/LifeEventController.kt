package org.goldenage.com.goldenage

import com.github.mikephil.charting.data.Entry

class LifeEventController
{
    var _lifeEvents : ArrayList<LifeEvent>? = null
    var _lifeEventEntrys : MutableList<Entry>? = null

    fun getLifeEvents() : ArrayList<LifeEvent>?
    {
        return _lifeEvents
    }

    fun getLifeEventEntrys() : MutableList<Entry>?
    {
        return _lifeEventEntrys
    }

    fun getMin() : Int
    {
        if (_lifeEvents!!.isEmpty())
            return 0

        var event = _lifeEvents!!.first()
        return event.age * 12 + event.month
    }

    fun getMax() : Int
    {
        if (_lifeEvents!!.isEmpty())
            return 10

        var event = _lifeEvents!!.last()
        return event.age * 12 + event.month
    }

    /**
     * 이벤트를 정렬함
     */
    fun alignmentEntryEvents()
    {
        if (_lifeEventEntrys == null)
            return

        _lifeEventEntrys!!.sortWith(object: Comparator<Entry>{
            override fun compare(o1: Entry?, o2: Entry?): Int = when{
                o1!!.x > o2!!.x -> 1
                else -> -1
            }
        })
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
                (o1!!.age * 12 + o1!!.month) > (o2!!.age * 12 + o2!!.month) -> 1
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
        addLifeEvent(LifeEvent(6,3,"배고파", -60))
        addLifeEvent(LifeEvent(10,2,"초등학교 졸업", 20))
        addLifeEvent(LifeEvent(18,10,"선데이토즈 입사", 60))
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
            _lifeEventEntrys = mutableListOf()
        }

        var x = lifeEvent.age.toFloat() * 12 + lifeEvent.month.toFloat()
        var y = lifeEvent.satisfaction.toFloat()

        _lifeEvents!!.add(lifeEvent)
        _lifeEventEntrys!!.add(Entry(x, y))
        alignmentEvents()
        alignmentEntryEvents()
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
            _lifeEventEntrys!!.removeAt(position)
        }
    }

}