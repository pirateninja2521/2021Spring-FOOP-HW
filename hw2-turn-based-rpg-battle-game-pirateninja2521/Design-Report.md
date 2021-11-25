# Design Report
> Please follow the instructions in homework 2 (officially announced version on NTU COOL) to finish the report.

## Software Design

> In this design report, you **DO NOT** need to illustrate your design of every class. 
> You only need to write down how do you achieve the Open-Close principle on those requirements which ask you to follow the Open-Close principle under certain cases.

- Follow the Open-Close Principle on removing/adding the implementations of AI units
  - abstract class entity.Unit: super class of HeroUnit and AIUnit. Contains abstract metheds selectAction(), selectTarget(), checkrule() and getInstance() for sub classes to implement.
  - class entity.Herounit / entity.AIUnit : read from utils.Inputs.in / utils.Inputs.ai to selection Action/Target.
  - class game.RPG : contains static List typeunits. In main function, manually add HeroUnit & AIUnit instance into RPG.typeunits. 
  - class entity.Troop : in method addUnit, we read the name of unit, then use RPG.typeunits and Unit.checkrule(), Unit,getInstance() to create a HeroUnit / AIUnit (whether the name is "Hero")
  
- Follow the Open-Close Principle on removing/adding the skill SelfHealing
  - class game.ActionHandler : contaions List typeskills to store all selected skills. Also, method stringToSkill() reads a string, and returns the Skill instance in typeskills that has the name. 
  - class game.RPG : contaions static ActionHandler actionhandler. In main function, it adds instances of selected skills to RPG.actionhandler. 
  - abstract class action.Action: super class of BasicAttack and Skill. Contains method selectTarget() to select target for the action (it calls unit.selectTarget if needed), and abstract method perform().
  - abstract class entity.Unit : contains List actions that stores the available actions of the unit, initialized by using RPG.actionhandler.stringToSkill().
  - abstract class action.Skill: sub class of Action, super class of SelfHealing, Summon, Petrochemical, etc. Override perform(), which provides a general perform() for sub classes.
  - class action.SelfHealing : sub class of Skill. It overrides methods selectTarget() (don't select target from enemyTroop) and perform() (add health to the unit itself). 
- Follow the Open-Close Principle on removing/adding the skill Summon
  - class action.Summon: sub class of Skill. It overrides methods selectTarget() (don't select target from enemyTroop) and perform() (add a unit to unit.troop, which will automatically be an AIUnit).

- Follow the Open-Close Principle on removing/adding the skill Petrochemical
  - class state.State : super class of Normal, Petrochemical, Poisoned, etc. contains abstract method changeBehavior() and method removeeffect().
  - abstract class entity.Unit : contains State state and int stateturns that records the current state. In method takeTurn(), it calls state.changeBehavior() before it select & perform an action, and calls state.removeEffect() after it. 
  - class action.Petrochemical : sub class of Skill. It overrides method perform(), which turns the target into "Petrochemical" state (via changeState() method of Unit). 
  - class state.Petrochemical : sub class of State. It Overides changeBehavior() (flip on unit.canperformaction) and removeEffect() (flip off unit.canperformaction) to skill the action in unit.takeTurns(). 

## Bonus Design

- Follow the Open-Close Principle on removing/adding the skill Curse
  - class game.ActionHandler : contaions List typedeadactions to store all selected DeadActions. 
  - class action.deadaction.DeadAction : super class of Cursed and PrintDeadMessage. Contains abstract method perform().
  - abstract class Unit : contains Set deadactions, which initially contains an instance of PrintDeadMessage. When a unit takes fatal demage, it performs all deadactions in unit.deadactions (thus prints "<target> dies.", result of PrintDeadMessage). 
  - class action.Curse : sub class of Skill. It overrides method perform(), which add "Cursed" DeadHandler to the target. 
  - class action.deadaction.Cursed : sub class of Deadaction. It overrides method perform(), which add health to the action unit according to target unit's MP. 

- Follow the Open-Close Principle on removing/adding the skill Cheerup
  - class action.Cheerup: sub class of Skill. It overrides methods selectTarget() (select 3 targets from ally) and perform() (turns targets into "Cheerup" state). 
  - class state.Cheerup: sub class of State. It Overides changeBehavior() (add 50 damage to all actions in unit.actions) and removeEffect() (minus 50 damage to all actions in unit.actions) to increase 50 damage of a unit of "Cheerup" state in that turn. 
- Follow the Open-Close Principle on removing/adding the skill OnePunch
  - class action.MyOnePunch : sub class of Skill. Its perform() make use of the class Onepunch provided by TA and the class OnePunchEvent.  
  - class entity.OnePunchEvent : implements interface Target provided by TA. Via method takeOnePunchDamage, we get the damage number from input, thus we can perform actually damage the target according to the number. 