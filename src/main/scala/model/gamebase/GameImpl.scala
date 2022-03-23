package model.gamebase

import com.google.inject.name.Named
import model.{Field, PlayerState, PlayerState1, GameState, Game}
import model.gamebase.FieldImpl

import javax.inject.Inject

case class GameImpl @Inject()(@Named("DefaultSize") override val size: 8 | 10 | 12, override val playerState: PlayerState, override val statusMessage: String, override val field: Field, override val gameState: GameState = GameState.IDLE) extends Game(size, playerState, statusMessage, field, gameState) {

  def this (size: 8 | 10 | 12) = this(size, new PlayerState1, "", FieldImpl(fieldSize = size), GameState.IDLE)

  override def recreate(size: 8 | 10 | 12 = size, playerState: PlayerState = playerState, statusMessage: String = statusMessage, field: Field = field, gameState: GameState = gameState): Game = copy(size, playerState, statusMessage, field, gameState)
}
